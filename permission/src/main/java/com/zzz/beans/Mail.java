package com.zzz.beans;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Mail {

    private String subject;  //主题

    private String message;   //信息

    private Set<String> receivers;   //收件人
}
