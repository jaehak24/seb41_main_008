package com.nfteam.server.Domain;


import lombok.*;

import javax.persistence.*;

@Getter
@ToString
@NoArgsConstructor
@Table(indexes = {
        @Index(columnList = "email",unique = true),
        @Index(columnList = "createdAt"),
        @Index(columnList = "createdBy")
})
@Entity
public class Member extends AuditingFields {
    @Id
    @Column(length = 50)
    private String userId;

    @Setter
    @Column(length=100)
    private String userPassword;

    @Setter
    @Column(length = 100)
    private String email;

    @Setter @Column(length = 100)
    private String nickname;

    @Builder
    private Member(String userId, String userPassword, String email, String nickname){
        this.userId=userId;
        this.userPassword=userPassword;
        this.email=email;
        this.nickname=nickname;
        this.modifiedBy=createdBy;

    }


    public static Member of(String username, String password, String email, String nickname) {
        return new Member(username,password,email,nickname);
    }
}
