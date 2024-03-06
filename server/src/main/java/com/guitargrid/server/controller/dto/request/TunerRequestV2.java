package com.guitargrid.server.controller.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.guitargrid.server.model.Image;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class TunerRequestV2 extends ProductRequestV2{

    private String display;
    private String design;
    private Boolean chromatic;
    private Boolean integrated_metronome;
    private Boolean integrated_microphone;

    public TunerRequestV2(  @JsonProperty("name") String name,
                            @JsonProperty("price") double price,
                            @JsonProperty("images") List<Image> images,
                            @JsonProperty("rating") int rating,
                            @JsonProperty("product_quantity") int product_quantity,
                            @JsonProperty("category") String category,
                            @JsonProperty("display") String display,
                            @JsonProperty("design") String design,
                            @JsonProperty("chromatic") Boolean chromatic,
                            @JsonProperty("integrated_metronome") Boolean integrated_metronome,
                            @JsonProperty("integrated_microphone") Boolean integrated_microphone) {
        super(name, price, images, rating, product_quantity, category);
        this.display = display;
        this.design = design;
        this.chromatic = chromatic;
        this.integrated_metronome = integrated_metronome;
        this.integrated_microphone = integrated_microphone;
    }
}
