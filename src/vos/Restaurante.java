package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class Restaurante
{

	@JsonProperty(value="id")
	private Long id;
	
	@JsonProperty(value="nombre")
	private String nombre;
	
	@JsonProperty(value="representante")
	private String representante;
	
	@JsonProperty(value="tipoComida")
	private String tipoComida;
	
	@JsonProperty(value="paginaWeb")
	private PaginaWeb paginaWeb;
	
	@JsonProperty(value="menus")
	private List<Menu> menus;
	
	@JsonProperty(value="zona")
	private Zona zona;
	
	
	
	
	
	
	
	





	public Restaurante(@JsonProperty(value="id")Long id, @JsonProperty(value="nombre")String nombre,@JsonProperty(value="representante")String representante,@JsonProperty(value="tipoComida")String tipoComida,@JsonProperty(value="paginaWeb")PaginaWeb paginaWeb,@JsonProperty(value="menus")List<Menu> menus,@JsonProperty(value="zona")Zona zona) {
		super();
		this.id=id;
		this.nombre=nombre;
		this.representante=representante;
		this.tipoComida=tipoComida;
		this.paginaWeb =paginaWeb;
		this.menus=menus;
		this.zona=zona;
	
		
		
	}

	private Long getId() {
		return id;
	}



	private void setId(Long id) {
		this.id = id;
	}



	private String getnombre() {
		return nombre;
	}



	private void setnombre(String nombre) {
		this.nombre = nombre;
	}



	private String getrepresentante() {
		return representante;
	}



	private void setrepresentante(String representante) {
		this.representante = representante;
	}



	private String gettipoComida() {
		return tipoComida;
	}



	private void settipoComida(String tipoComida) {
		this.tipoComida = tipoComida;
	}

	private PaginaWeb getpaginaWeb() {
		return paginaWeb;
	}

	private void setpaginaWeb(PaginaWeb paginaWeb) {
		this.paginaWeb = paginaWeb;
	}

	private List<Menu> getmenu() {
		return menus;
	}

	private void setmenu(List<Menu> menus) {
		this.menus = menus;
	}

	private Zona getzona() {
		return zona;
	}

	private void setzona(Zona zona) {
		this.zona = zona;
	}

	
}
