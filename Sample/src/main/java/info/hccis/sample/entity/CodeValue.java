package info.hccis.sample.entity;

/**
 * Represents a code value
 * @author bjmaclean
 * @since 20211004
 */
public class CodeValue {
    
    private int codeType;
    private int codeValueSequence;
    private String description;

    public CodeValue(int codeType, int codeValueSequence, String description) {
        this.codeType = codeType;
        this.codeValueSequence = codeValueSequence;
        this.description = description;
    }

    public CodeValue() {
    }

    
    
    public int getCodeType() {
        return codeType;
    }
    
    

    public void setCodeType(int codeType) {
        this.codeType = codeType;
    }

    public int getCodeValueSequence() {
        return codeValueSequence;
    }

    public void setCodeValueSequence(int codeValueSequence) {
        this.codeValueSequence = codeValueSequence;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
    
}
