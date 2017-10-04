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
	
	@JsonProperty(value="idZona")
	private Long idZona;
	
	@JsonProperty(value="idPaginaWeb")
	private Long idPaginaWeb;
	
	public Restaurante(@JsonProperty(value="id")Long id, @JsonProperty(value="nombre")String nombre,@JsonProperty(value="representante")String representante,@JsonProperty(value="tipoComida")String tipoComida,@JsonProperty(value="paginaWeb")PaginaWeb paginaWeb,@JsonProperty(value="menus")List<Menu> menus,@JsonProperty(value="zona")Zona zona,@JsonProperty(value="idZona")Long idZona, @JsonProperty(value="idPaginaWeb")Long idPaginaWeb ) {
		super();
		this.id=id;
		this.nombre=nombre;
		this.representante=representante;
		this.tipoComida=tipoComida;
		this.paginaWeb =paginaWeb;
		this.menus=menus;
		this.zona=zona;
		this.idPaginaWeb=idPaginaWeb;
		this.idZona= idZona;
	
		
		
	}
	public Restaurante()
	{
		
	}


	public Long getId() {
	return id;
}



public void setId(Long id) {
	this.id = id;
}



public String getnombre() {
	return nombre;
}



public void setnombre(String nombre) {
	this.nombre = nombre;
}



public String getrepresentante() {
	return representante;
}



public void setrepresentante(String representante) {
	this.representante = representante;
}



public String gettipoComida() {
	return tipoComida;
}



public void settipoComida(String tipoComida) {
	this.tipoComida = tipoComida;
}

public PaginaWeb getpaginaWeb() {
	return paginaWeb;
}

public void setpaginaWeb(PaginaWeb paginaWeb) {
	this.paginaWeb = paginaWeb;
}

public List<Menu> getmenu() {
	return menus;
}

public void setmenu(List<Menu> menus) {
	this.menus = menus;
}

public Zona getzona() {
	return zona;
}

public void setzona(Zona zona) {
	this.zona = zona;
}

public Long getIdZona() {
	return idZona;
}

public void setIdZona(Long idZona) {
	this.idZona = idZona;
}

public Long getIdPaginaWeb() {
	return idPaginaWeb;
}

public void setIdPaginaWeb(Long idPaginaWeb) {
	this.idPaginaWeb = idPaginaWeb;
}

	
}
