package com.myfirstproject.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import com.myfirstproject.dao.UserDAO;
@SuppressWarnings({ "serial", "deprecation" })
@Entity
@Table(name = "user")
public class User implements Serializable, UserDetails {

	private Long id;
	private UUID token;
	private String firstName;
	private String lastName;
	private String userName;
	private String myfirstprojectAddress;
	private Boolean active;
	private String password;
	private String clientName;
	private Date createDate;
	private String accountType;
	private String salutation;
	private String middleName;
	private String dob;
	private String passport;
	private String passportExpire;
	private String prefLanguage;
	private String birthCountry;
	private String residenceCountry;
	private String citiCountry;
	private String pinCode;
	private String city;
	private String state;
	private String phoneNumber;
	private int otp;
	private String profession;
	private String companyName;
	private String message;
	private Long userId;



	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long returnId) {
		this.userId = returnId;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public UUID getToken() {
		return token;
	}

	public void setToken(UUID token) {
		this.token = token;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getmyfirstprojectAddress() {
		return myfirstprojectAddress;
	}

	public void setmyfirstprojectAddress(String myfirstprojectAddress) {
		this.myfirstprojectAddress = myfirstprojectAddress;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public int getOtp() {
		return otp;
	}

	public void setOtp(int otp) {
		this.otp = otp;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getSalutation() {
		return salutation;
	}

	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getPassport() {
		return passport;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}

	public String getPassportExpire() {
		return passportExpire;
	}

	public void setPassportExpire(String passportExpire) {
		this.passportExpire = passportExpire;
	}

	public String getPrefLanguage() {
		return prefLanguage;
	}

	public void setPrefLanguage(String prefLanguage) {
		this.prefLanguage = prefLanguage;
	}

	public String getBirthCountry() {
		return birthCountry;
	}

	public void setBirthCountry(String birthCountry) {
		this.birthCountry = birthCountry;
	}

	public String getResidenceCountry() {
		return residenceCountry;
	}

	public void setResidenceCountry(String residenceCountry) {
		residenceCountry = residenceCountry;
	}

	public String getCitiCountry() {
		return citiCountry;
	}

	public void setCitiCountry(String citiCountry) {
		this.citiCountry = citiCountry;
	}

	@Override
	@Transient
	public Collection<? extends GrantedAuthority> getAuthorities() {

		GrantedAuthority auth = new GrantedAuthorityImpl("User");
		Collection<GrantedAuthority> authorities = new LinkedList<GrantedAuthority>();
		authorities.add(auth);
		return authorities;
	}

	@Override
	@Transient
	public String getUsername() {
		return userName;
	}

	@Override
	@Transient
	public boolean isAccountNonLocked() {
		return active;
	}

	@Override
	@Transient
	public boolean isCredentialsNonExpired() {
		return active;
	}

	@Override
	@Transient
	public boolean isEnabled() {
		return active;
	}

	@Override
	@Transient
	public boolean isAccountNonExpired() {
		return active;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", token=" + token + ", userName=" + userName + ", myfirstprojectAddress=" + myfirstprojectAddress
				+ ", active=" + active + ", password=" + password + ", clientName=" + clientName + ", createDate="
				+ createDate + ", accountType=" + accountType + ", pinCode=" + pinCode + ", city=" + city + ", state="
				+ state + ", phoneNumber=" + phoneNumber + ", otp=" + otp + ", profession=" + profession
				+ ", companyName=" + companyName + ", message=" + message + ",citiCountry=" + citiCountry
				+ ",residenceCountry=" + residenceCountry + ",birthCountry=" + birthCountry + "," + "prefLanguage="
				+ prefLanguage + ",passportExpire=" + passportExpire + ",passport=" + passport + ",dob=" + dob
				+ ",middleName=" + middleName + ",middleName=" + middleName + ",userId="+userId+"]";
	}
}