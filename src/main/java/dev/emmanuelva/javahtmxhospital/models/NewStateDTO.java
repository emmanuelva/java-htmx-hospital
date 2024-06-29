package dev.emmanuelva.javahtmxhospital.models;

import dev.emmanuelva.javahtmxhospital.utils.TextUtils;
import lombok.Data;

import java.util.Map;
import java.util.UUID;

@Data
public class NewStateDTO {
    private UUID id;
    private String name;
    private String normalizedName;
    private String alias;

    public static StateDTOBuilder builder() {
        return new StateDTOBuilder();
    }

    public static class StateDTOBuilder
    {
        private UUID id;
        private String name;
        private String normalizedName;
        private String alias;

        public StateDTOBuilder id(UUID id) {
            this.id = id;
            return this;
        }

        public StateDTOBuilder name(String name) {
            this.name = name;
            this.normalizedName = TextUtils.normalizeText(name);
            return this;
        }

        public StateDTOBuilder alias(String alias) {
            this.alias = alias;
            return this;
        }

        public NewStateDTO build() {
            NewStateDTO stateDTO = new NewStateDTO();
            stateDTO.id = id;
            stateDTO.setName(name);
            stateDTO.setNormalizedName(normalizedName);
            stateDTO.setAlias(alias);
            return stateDTO;
        }
    }
}
