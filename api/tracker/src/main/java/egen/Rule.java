package egen;


//public enum  Rule {
//
//    HIGHRPM,
//    LOWFUEL,
//    TIREPRESSURE,
//    LOWENGINECOOLANT_ENGINELIGHTON
//
//}

public enum Rule {
    HIGHRPM {
        public String toString() {
            return "HIGH";
        }
    },

    LOWFUEL {
        public String toString() {
            return "MEDIUM";
        }
    },

    TIREPRESSURE {
        public String toString() {
            return "LOW";
        }
    },

    LOWENGINECOOLANT_ENGINELIGHTON {
        public String toString() {
            return "LOW";
        }
    }
}
