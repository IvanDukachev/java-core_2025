package lr8;

import org.json.simple.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.json.simple.JSONArray;

import java.io.FileWriter;
import java.io.IOException;

public class HTML_update {
    public static void main(String[] args) {
        String url = "https://www.e1.ru/text/";

        try {
            Document doc = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0")
                    .timeout(10 * 1000)
                    .get();

            int statusCode = doc.connection().response().statusCode();
            if (statusCode != 200) {
                System.err.println("Ошибка при получении страницы: HTTP статус " + statusCode);
                return;
            }

            Element newsList = doc.selectFirst("div.announcementList_791RY");
            if (newsList == null) {
                System.err.println("Ошибка: Не найден список новостей. Возможно, структура сайта изменилась или данные загружаются динамически.");
                return;
            }

            Elements newsItems = newsList.select("div.wrap_RL97A");

            if (newsItems.isEmpty()) {
                System.out.println("На странице не найдено новостей.");
                return;
            }

            JSONArray newsArray = new JSONArray();

            for (Element item : newsItems) {
                String topic = extractTopic(item);
                String title = extractTitle(item);
                String dateTime = extractDateTime(item);

                JSONObject newsItem = new JSONObject();
                newsItem.put("topic", topic);
                newsItem.put("title", title);
                newsItem.put("datetime", dateTime);

                newsArray.add(newsItem);
            }

            JSONObject result = new JSONObject();
            result.put("news", newsArray);

            try (FileWriter file = new FileWriter("src/lr8/news.json")) {
                file.write(result.toJSONString());
                System.out.println("Данные успешно сохранены в файл news.json");
            }

        } catch (IOException e) {
            System.err.println("Сетевая ошибка или ошибка записи файла:");
            System.err.println("Сообщение: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Непредвиденная ошибка:");
            e.printStackTrace();
        }
    }

    private static String extractTopic(Element item) {
        try {
            Element topicEl = item.selectFirst("div.content_RL97A div.textBox_RL97A div.wrap_8vmq0 div.row_8vmq0 div.taxonomies_8vmq0 a.label_i8AXi span.d-flex");
            return topicEl != null ? topicEl.text().trim() : "Без темы";
        } catch (Exception e) {
            return "Ошибка извлечения темы";
        }
    }

    private static String extractTitle(Element item) {
        try {
            Element titleEl = item.selectFirst("div.content_RL97A div.textBox_RL97A a.header_RL97A");
            return titleEl != null ? titleEl.text().trim() : "Без заголовка";
        } catch (Exception e) {
            return "Ошибка извлечения заголовка";
        }
    }

    private static String extractDateTime(Element item) {
        try {
            Element timeEl = item.selectFirst("div.wrap_eiDCU div.cell_eiDCU span.text_eiDCU");
            return timeEl != null ? timeEl.text().trim() : "Без даты";
        } catch (Exception e) {
            return "Ошибка извлечения даты";
        }
    }
}