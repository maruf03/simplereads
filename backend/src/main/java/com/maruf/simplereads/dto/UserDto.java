package com.maruf.simplereads.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@ToString
public class UserDto {
    private Integer id;
    private String fullName;
    private String email;
    private LocalDateTime createdAt; 
    private String bio;
}
