package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class Menu 


{

	@JsonProperty(value="id")
	private Long id;
	
	@JsonProperty(value="nombre")
	private String nombre;
	
	@JsonProperty(value="descripcion")
	private String descripcion;
	
	@JsonProperty(value="traduccion")
	private String traduccion;
	
	@JsonProperty(value="equivalentes")
	private List<Ingrediente> equivalentes;
	
	@JsonProperty(value="productos")
	private List<Producto> productos;



	public Menu(@JsonProperty(value="id")Long id, @JsonProperty(value="nombre")String nombre,@JsonProperty(value="descripcion")String descripcion,@JsonProperty(value="traduccion")String traduccion,@JsonProperty(value="equivalentes")List<Ingrediente> equivalentes,@JsonProperty(value="productos")List<Producto>productos) {
		super();
		this.id=id;
		this.nombre=nombre;
		this.descripcion=descripcion;
		this.traduccion=traduccion;
		this.equivalentes=equivalentes;
		this.productos=productos;
		
	}
}
