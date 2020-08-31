package com.springelasticsearch.entity;

import lombok.*;
import org.elasticsearch.search.DocValueFormat;
import org.joda.time.DateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

@Document(indexName = "kisiler")
//Bunlar lombok Sayesinde
@Getter //Tum Getter Metodlari
@Setter //Tum Setter Metodlari
@NoArgsConstructor //Parametresiz Olusturma
@AllArgsConstructor //Tum Fieldlarin Parametre Olarak Alindigi Kurucu Metod
public class Kisi {
    @Id
    private String id;
    @Field(name="ad",type = FieldType.Text)
    private String ad;
    @Field(name="soyad",type = FieldType.Text)
    private String soyad;
    @Field(name="adres",type = FieldType.Text)
    private String adres;
    @Field(name="dogumTarih",type = FieldType.Text)
    private Date dogumTarihi;

}
