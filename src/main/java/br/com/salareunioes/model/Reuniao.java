package br.com.salareunioes.model;

import java.time.LocalDate;

public class Reuniao {

	private Integer id;
	private String titulo;
	private String solicitante;
	private LocalDate data;
	private String inicio;
	private String fim;
	private LocalDate dataAgendamento;
	private String organizador;
	private Integer sala;
	private boolean excluido;
	private String observacoes;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getSolicitante() {
		return solicitante;
	}
	
	public void setSolicitante(String solicitante) {
		this.solicitante = solicitante;
	}
	
	public LocalDate getData() {
		return data;
	}
	
	public void setData(LocalDate data) {
		this.data= data;
	}
	
	public String getInicio() {
		return inicio;
	}
	
	public void setInicio(String inicio) {
		this.inicio = inicio;
	}
	
	public String getFim() {
		return fim;
	}

	public void setFim(String fim) {
		this.fim = fim;
	}

	public boolean isExcluido() {
		return excluido;
	}
	
	public void setExcluido(boolean exluido) {
		this.excluido = exluido;
	}
	
	public LocalDate getDataAgendamento() {
		return dataAgendamento;
	}
	
		
	public String getOrganizador() {
		return organizador;
	}
	
	public void setOrganizador(String organizador) {
		this.organizador = organizador;
	}
	
	public Integer getSala() {
		return sala;
	}
	
	public void setSala(Integer sala) {
		this.sala = sala;
	}
	
	public String getObservacoes() {
		return observacoes;
	}
	
	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	
	@Override
	public String toString() {
		return "Reuniao [id=" + id + ", titulo=" + titulo + ", solicitante=" + solicitante + ", dataReuniao="
				+ data + ", inicio=" + inicio + ", fim=" + fim + ", dataAgendamento=" + dataAgendamento
				+ ", organizador=" + organizador + ", sala=" + sala + ", excluido=" + excluido + "]\n";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((fim == null) ? 0 : fim.hashCode());
		result = prime * result + ((inicio == null) ? 0 : inicio.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}
	
	
}
