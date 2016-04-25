package rblearning.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name="lessions")
public class Lession extends AbstractPersistable<Long> {
	
	private static final long serialVersionUID = 1L;

	@Column(nullable=false, length=150)
	private String name;
	
	@Column(nullable=false, length=250)
	private String summary;
	
	@Column(nullable=true, columnDefinition="TEXT")
	private String content;
	
	@Column(nullable=true, length=150)
	private String videoUrl;
	
	@Column(name="created_at", nullable=false)
	private Date createdAt;
	
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name="id_class")
	private Class myClass;
	
	@Column(nullable=false)
	private boolean visible;
	
	@Enumerated(EnumType.STRING)
	@Column(name="lession_type", nullable=false, length=15)
	private LessionType lessionType;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Class getMyClass() {
		return myClass;
	}

	public void setMyClass(Class myClass) {
		this.myClass = myClass;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public LessionType getLessionType() {
		return lessionType;
	}

	public void setLessionType(LessionType lessionType) {
		this.lessionType = lessionType;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}
}
