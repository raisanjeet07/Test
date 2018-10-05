package com.san.mkeiteasy;

import lombok.Data;

@Data
public class PropertyJson {
    String _class = "com.medlife.configclient.data.Property";
    String component="";
    String key="";
    String value="";
    String createdTime="$date";
    String updatedTime="$date"; 
    String updatedBy="Admin";
}
