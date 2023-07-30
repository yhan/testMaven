import java.util.Objects;

public record Flight(String from, String to, int capacity) {
    public Flight{
    }
    public static class Builder{
        private String from;
        private String to;
        private int capacity;
        public Builder from(String from){
            this.from = (from);
            return this;
        }
        public Builder to(String to){
            this.to = (to);
            return this;
        }
        public Builder capacity(int cap){
            this.capacity = (cap);
            return this;
        }
        public Flight build() {
            return new Flight(from, to, capacity);
        }
    }
}

