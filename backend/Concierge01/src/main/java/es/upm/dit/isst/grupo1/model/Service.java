package es.upm.dit.isst.grupo1.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity(name="Service")
public class Service implements Serializable {

		private static final long serialVersionUID = 1L;
		

		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private int id;
		@ManyToOne
		@JoinColumn(name = "cliente", referencedColumnName = "id")
		private Client cliente;
		private boolean disponibilidad;
		private String data;
		
	
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		
		public Client getCliente() {
			return cliente;
		}
		public void setCliente(Client cliente) {
			this.cliente = cliente;
		}
		public boolean isDisponibilidad() {
			return disponibilidad;
		}
		public void setDisponibilidad(boolean disponibilidad) {
			this.disponibilidad = disponibilidad;
		}
		public String getData() {
			return data;
		}
		public void setData(String data) {
			this.data = data;
		}
		
		
		
}		