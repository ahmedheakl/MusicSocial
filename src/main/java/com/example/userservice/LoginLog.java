package com.example.userservice;

public class LoginLog {
    private String error = "";
    private boolean ok = true;
    private String expected = "";
    private String found = "";

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public boolean getOk() {
        return this.ok;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getError() {
        return this.error;
    }

    public void setExpected(String expected) {
        this.expected = expected;
    }

    public String getExpected() {
        return this.expected;
    }

    public void setFound(String found) {
        this.found = found;
    }

    public String getFound() {
        return this.found;
    }
}
