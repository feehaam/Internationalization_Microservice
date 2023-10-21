package com.ladder.i18n.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Translation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long translationId;

    private String languageName;
    private String languageCode;
    /*
     * For my sql it should be like this: @Column(columnDefinition = "TEXT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci")
     * Little customized for ms sql server
     * Also in the db connection string, "characterEncoding=UTF-8" is added
     */
    @Column(columnDefinition = "nvarchar(max) COLLATE Latin1_General_100_CI_AS_SC_UTF8")
    private String localizedText;


    @ManyToOne @JoinColumn(name = "resource_id") @JsonIgnore
    private LocalizedResource parentResource;
}
