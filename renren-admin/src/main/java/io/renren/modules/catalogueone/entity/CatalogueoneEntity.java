package io.renren.modules.catalogueone.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("Catalogueone")
public class CatalogueoneEntity {
    private static final long serialVersionUID = 1L;
    private int catalogueone_id;
    private String catalogueone_name;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getCatalogueone_id() {
        return catalogueone_id;
    }

    public void setCatalogueone_id(int catalogueone_id) {
        this.catalogueone_id = catalogueone_id;
    }

    public String getCatalogueone_name() {
        return catalogueone_name;
    }

    public void setCatalogueone_name(String catalogueone_name) {
        this.catalogueone_name = catalogueone_name;
    }
}
