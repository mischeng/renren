package io.renren.modules.cataloguetwo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("Cataloguetwo")
public class CataloguetwoEntity {
    private static final long serialVersionUID = 1L;
    private int cataloguetwo_id;
    private String cataloguetwo_name;
    private int catalogueone_id;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getCataloguetwo_id() {
        return cataloguetwo_id;
    }

    public void setCataloguetwo_id(int cataloguetwo_id) {
        this.cataloguetwo_id = cataloguetwo_id;
    }

    public String getCataloguetwo_name() {
        return cataloguetwo_name;
    }

    public void setCataloguetwo_name(String cataloguetwo_name) {
        this.cataloguetwo_name = cataloguetwo_name;
    }

    public int getCatalogueone_id() {
        return catalogueone_id;
    }

    public void setCatalogueone_id(int catalogueone_id) {
        this.catalogueone_id = catalogueone_id;
    }
}
