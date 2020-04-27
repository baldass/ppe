package com.fsw.config;

import java.io.Serializable;

public class ApiResponse extends Exception {
    private int state;
    private String msg;
    private Object data;

    @Override
    public String toString() {
        return "{\"state\":"+state+",\"msg\":\""+msg+"\",\"data\":\""+data+"\"}";
    }

    public static class Builder {

        private ApiResponse response;

        public Builder() {
            this.response = new ApiResponse();
        }

        public Builder msg(String msg) {
            this.response.msg=msg;
            return this;
        }

        public Builder state(int state) {
            this.response.state=state;
            return this;
        }


        public Builder data(Object data) {
            this.response.data=data;
            return this;
        }

        public ApiResponse build() {
            return this.response;
        }
    }
}
