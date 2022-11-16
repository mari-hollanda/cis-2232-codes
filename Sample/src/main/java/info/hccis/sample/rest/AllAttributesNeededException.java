package info.hccis.sample.rest;

/**
 * Used if all attributes not provided
 * @author bjm
 * @since 6-Nov-2020
 */
public class AllAttributesNeededException extends Exception{
    public AllAttributesNeededException(String message){
        super(message);
    }
}
