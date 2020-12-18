package nativeapp.enums;

@SuppressWarnings("unused")
public enum FooterItem {
    HOME {
        public String toString() {
            return "Home";
        }
    },
    WEBVIEW {
        public String toString() {
            return "WebView";
        }
    },
    LOGIN {
        public String toString() {
            return "Login";
        }
    },
    FORMS {
        public String toString() {
            return "Forms";
        }
    },
    SWIPE {
        public String toString() {
            return "Swipe";
        }
    }
}