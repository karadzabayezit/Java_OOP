public enum SortCriteria {
    BY_NAME("Name"),
    BY_YEAR("Year"),
    BY_WHEEL_SIZE("Wheel Size"),
    BY_NAME_YEAR("Name and Year");

    private final String criteriaName;

    SortCriteria(String criteriaName) {
        this.criteriaName = criteriaName;
    }

    public String getCriteriaName() {
        return criteriaName;
    }
}