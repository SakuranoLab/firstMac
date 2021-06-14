
package firstMac.jsonSample;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "_id",
    "__v",
    "text",
    "updatedAt",
    "deleted",
    "source",
    "sentCount"
})
public class CatFactsRandom {

    @JsonProperty("_id")
    public String id;
    @JsonProperty("__v")
    public Integer v;
    @JsonProperty("text")
    public String text;
    @JsonProperty("updatedAt")
    public String updatedAt;
    @JsonProperty("deleted")
    public Boolean deleted;
    @JsonProperty("source")
    public String source;
    @JsonProperty("sentCount")
    public Integer sentCount;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
