package dev.emmanuelva.javahtmxhospital.models;

import dev.emmanuelva.javahtmxhospital.utils.TextUtils;
import lombok.Data;
import lombok.Getter;

import java.util.Map;
import java.util.UUID;

@Getter
public class NewCityDTO {
    private UUID id;
    private String name;
    private String normalizedName;
    private String alias;

    private StateDTO state;

    public static CityDTOBuilder builder() {
        return new CityDTOBuilder();
    }

    public static class CityDTOBuilder
    {
        private UUID id;
        private String name;
        private String normalizedName;
        private String alias;
        private StateDTO state;

        public CityDTOBuilder id(UUID id) {
            this.id = id;
            return this;
        }

        public CityDTOBuilder name(String name) {
            this.name = name;
            this.normalizedName = TextUtils.normalizeText(name);
            return this;
        }

        public CityDTOBuilder alias(String alias) {
            this.alias = alias;
            return this;
        }

        public CityDTOBuilder state(StateDTO state) {
            this.state = state;
            return this;
        }

        public NewCityDTO build() {
            NewCityDTO cityDTO = new NewCityDTO();
            cityDTO.id = id;
            cityDTO.name = name;
            cityDTO.normalizedName = normalizedName;
            cityDTO.alias = alias;
            cityDTO.state = state;
            return cityDTO;
        }
    }
}
