/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.hccis.sample.bo;

import info.hccis.sample.dao.CodeValueDAO;
import info.hccis.sample.entity.CodeValue;
import java.util.ArrayList;

/**
 *
 * @author bjmaclean
 */
public class CodeValueBO {

    /**
     * Select all code values based on code type
     *
     * @since 20210924
     * @author BJM
     */
    public ArrayList<CodeValue> selectCodeValues(int codeTypeId) {
        CodeValueDAO codeValueDAO = new CodeValueDAO();
        return codeValueDAO.selectCodeValues(codeTypeId);
    }
}
