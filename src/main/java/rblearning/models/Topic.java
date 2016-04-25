package rblearning.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name="topics")
public class Topic extends AbstractPersistable<Long> {
	
	private static final long serialVersionUID = 1L;

	@Column(nullable=false, length=150)
	private String name;
	
	@Column(nullable=false, length=250)
	private String description;
	
	@Column(nullable=true, length=150)
	private String image;
	
	@Column(name="tag_color", nullable=true, length=10)
	private String tagColor;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getTagColor() {
		return tagColor;
	}

	public void setTagColor(String tagColor) {
		this.tagColor = tagColor;
	}
}
