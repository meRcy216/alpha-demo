package io.example.pub.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
public class Mail implements Serializable {
	private String receiver = null;
	private String title = null;
	private String content = null;

}
