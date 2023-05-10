package yandex_academy_3;

public class Solution {

}

class Offer {
    private String id;
    private int price;
    private int stock_count;
    private PartnerContent partnerContent;

    public Offer(String id, int price, int stock_count, PartnerContent partnerContent) {
        this.id = id;
        this.price = price;
        this.stock_count = stock_count;
        this.partnerContent = partnerContent;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock_count() {
        return stock_count;
    }

    public void setStock_count(int stock_count) {
        this.stock_count = stock_count;
    }

    public PartnerContent getPartnerContent() {
        return partnerContent;
    }

    public void setPartnerContent(PartnerContent partnerContent) {
        this.partnerContent = partnerContent;
    }

    private class PartnerContent {
        private String title;
        private String description;

        public PartnerContent(String title, String description) {
            this.title = title;
            this.description = description;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }
}

class Message {
    private String trace_id;
    private Offer offer;

    public Message(String trace_id, Offer offer) {
        this.trace_id = trace_id;
        this.offer = offer;
    }

    public String getTrace_id() {
        return trace_id;
    }

    public void setTrace_id(String trace_id) {
        this.trace_id = trace_id;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }
}

class Service {
    
}

