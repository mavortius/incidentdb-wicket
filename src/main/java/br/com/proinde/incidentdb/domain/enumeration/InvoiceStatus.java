package br.com.proinde.incidentdb.domain.enumeration;

public enum InvoiceStatus {
    NOT_PRESENTED("Not Presented"),
    OUTSTANDING("Outstanding"),
    SETTLED("Settled");

    private String label;

    InvoiceStatus(String label) {
        this.label = label;
    }
    @Override
    public String toString() {
        return label;
    }
}
