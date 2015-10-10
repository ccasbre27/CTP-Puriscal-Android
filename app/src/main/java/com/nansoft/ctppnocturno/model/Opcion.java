package com.nansoft.ctppnocturno.model;

public class Opcion
{
    private int Id;
	private String Titulo;
	private String Subtitulo;
	private int Imagen;
	
	public Opcion(int pId, String pTitulo, String pSubtitulo, int pImagen)
	{
        Id = pId;
		Titulo = pTitulo;
		Subtitulo = pSubtitulo;
		Imagen = pImagen;
	}
	public int getId()
    {
        return Id;
    }

    public void setId(int pId)
    {
        Id= pId;
    }

	public String getTitulo()
	{
		return Titulo;
	}
	
	public void setTitulo(String pTitulo)
	{
		Titulo = pTitulo;
	}
	
	public String getSubtitulo()
	{
		return Subtitulo;
	}
	
	public void setSubtitulo(String pSubtitulo)
	{
		Subtitulo = pSubtitulo;
	}
	
	public int getImagen()
	{
		return Imagen;
	}
	
	public void setImagen(int pImagen)
	{
		Imagen = pImagen;
	}
}
