package com.OURganizer.OURganizerProject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "websites")
public class Websites {
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Long id;
		private String websiteName;
		private String url;
		
		
		public Websites(Long id, String websiteName, String url) {
			super();
			this.id = id;
			this.websiteName = websiteName;
			this.url = url;
		}
		
		public Websites() {
		}

		public Long getId() {
			return id;
		}


		public void setId(Long id) {
			this.id = id;
		}


		public String getWebsiteName() {
			return websiteName;
		}


		public void setWebsiteName(String websiteName) {
			this.websiteName = websiteName;
		}


		public String getUrl() {
			return url;
		}


		public void setUrl(String url) {
			this.url = url;
		}
		
		
	
}
