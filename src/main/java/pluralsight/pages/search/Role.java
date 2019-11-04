package pluralsight.pages.search;

public enum Role {
    BUSINESS_PROFESSIONAL("Business Professional"), SOFTWARE_DEVELOPMENT("Software Development");

    private String value;

    Role(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

}
