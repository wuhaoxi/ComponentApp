package com.wu.voice.model.discory;

import com.wu.voice.model.BaseModel;
import java.util.ArrayList;

/**
 * @author: wuhx
 * @function:
 */
public class RecommandHeadValue extends BaseModel {

    public ArrayList<String> ads;
    public ArrayList<RecommandMiddleValue> middle;
    public ArrayList<RecommandFooterValue> footer;

}
