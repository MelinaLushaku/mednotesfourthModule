package com.example.mednotes4.Helper;

import java.io.Serializable;

public class ConversationResponse<T> implements Serializable {
    private T data;
    private String mesazhi;
    private int statusi;
    private String errori;

    public ConversationResponse(ConversationResponseBuilder conversationResponseBuilder){
        this.data=(T)conversationResponseBuilder.data;
        this.mesazhi=conversationResponseBuilder.mesazhi;
        this.statusi=conversationResponseBuilder.statusi;
        this.errori=conversationResponseBuilder.errori;
    }



    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMesazhi() {
        return mesazhi;
    }

    public void setMesazhi(String mesazhi) {
        this.mesazhi = mesazhi;
    }

    public int getStatusi() {
        return statusi;
    }

    public void setStatusi(int statusi) {
        this.statusi = statusi;
    }

    public String getErrori() {
        return errori;
    }

    public void setErrori(String errori) {
        this.errori = errori;
    }

    public static class ConversationResponseBuilder<T>{
        private T data;
        private String mesazhi;
        private int statusi;
        private String errori;
        public ConversationResponseBuilder(int statusi){
            this.statusi = statusi;
        }
        public ConversationResponseBuilder setData(T data){
            this.data = data;
            return this;
        }
        public ConversationResponseBuilder setMesazhin(String mesazhi){
            this.mesazhi = mesazhi;
            return this;
        }
        public ConversationResponseBuilder setErrorin(String errori){
            this.errori = errori;
            return this;
        }
        public ConversationResponse build(){
            return new ConversationResponse (this);
        }

    }
}
