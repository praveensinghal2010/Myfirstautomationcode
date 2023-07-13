package Pages;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;


@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class Product {
	@JsonProperty("name")
	    private String name;
	@JsonProperty("data")
		private DataObject data;
		
	    public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public DataObject getData() {
			return data;
		}

		public void setData(DataObject data) {
			this.data = data;
		}

	

	    public Product() {
	    }
}


