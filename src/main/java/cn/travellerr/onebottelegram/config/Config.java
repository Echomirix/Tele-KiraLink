package cn.travellerr.onebottelegram.config;

import cn.chahuyun.hibernateplus.DriveType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Map;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ConfigEntity(name = "config", filePath = "./")
public class Config implements Serializable {

    private Telegram telegram;
    private Onebot onebot;
    private Spring spring;
    private Command command;


    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Telegram implements Serializable {

        private Config.Telegram.Bot bot;
        private Config.Telegram.Webhook webhook;

        @Data
        @Builder
        @AllArgsConstructor
        @NoArgsConstructor
        public static class Bot implements Serializable {
            private String token;
            private String username;
            private Config.Telegram.Bot.Proxy proxy;
            private boolean useTranslator;
            private String bingToken;
            private String bingKey;

            @Data
            @Builder
            @AllArgsConstructor
            @NoArgsConstructor
            public static class Proxy implements Serializable {
                private String host;
                private int port;
                private String username;
                private String secret;
                private String type;
            }


        }

        @Data
        @Builder
        @AllArgsConstructor
        @NoArgsConstructor
        public static class Webhook implements Serializable {
            private String certPath;
            private String secret;
            private String url;
            private int port;
            private boolean useWebhook;
        }
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Onebot implements Serializable {
            private String ip;
            private String path;
            private int port;
            private String token;
            private boolean useArray;
            private boolean banGroupUser;
            private String groupUserWarning;
            private boolean picBase64;
            private int silkSampleRate;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Spring implements Serializable {
        private Config.Spring.Database database;
        private Config.Spring.Webui webui;
        private String ffmpegPath;


        @Data
        @Builder
        @AllArgsConstructor
        @NoArgsConstructor
        public static class Database implements Serializable {
            private DriveType dataType;
            private String mysqlUrl;
            private String mysqlUser;
            private String mysqlPassword;
        }

        @Data
        @Builder
        @AllArgsConstructor
        @NoArgsConstructor
        public static class Webui implements Serializable {
            private String userName;
            private String password;
        }
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Command implements Serializable {
        private String prefix;
        private Map<String, String> menu;
        private Map<String, String> commandMap;
    }
}
