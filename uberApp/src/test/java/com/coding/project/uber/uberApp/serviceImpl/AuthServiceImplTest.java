package com.coding.project.uber.uberApp.serviceImpl;

import com.coding.project.uber.uberApp.dto.SignUpDto;
import com.coding.project.uber.uberApp.dto.UserDto;
import com.coding.project.uber.uberApp.entities.User;
import com.coding.project.uber.uberApp.entities.enums.Role;
import com.coding.project.uber.uberApp.repositories.UserRepository;
import com.coding.project.uber.uberApp.security.JWTService;
import com.coding.project.uber.uberApp.services.RiderService;
import com.coding.project.uber.uberApp.services.WalletService;
import com.coding.project.uber.uberApp.services.impl.AuthServiceImpl;
import com.coding.project.uber.uberApp.services.impl.RiderServiceImpl;
import com.coding.project.uber.uberApp.services.impl.WalletServiceImpl;
import org.assertj.core.api.AbstractFileAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.Mockito.*;
import static org.postgresql.hostchooser.HostRequirement.any;

@ExtendWith(MockitoExtension.class)
public class AuthServiceImplTest {

    @Mock
    private WalletServiceImpl walletService;

    @Mock
    private RiderServiceImpl riderService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private JWTService jwtService;

    @Mock
    private AuthenticationManager authenticationManager;

    @Spy
    private ModelMapper modelMapper;

    @Spy
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private AuthServiceImpl authService;

    private User user;

    @BeforeEach
    void setUp(){
        user = new User();
        user.setId(1L);
        user.setEmail("test@gmail.com");
        user.setPassword("testPassword");
        user.setRoles(Set.of(Role.RIDER));
    }

    @Test
    void testLogin_whenSuccess(){
        //arrange

        Authentication authentication = mock(Authentication.class);
        when(authenticationManager.authenticate(any(Authentication.class))).thenReturn(authentication);
        when(authentication.getPrincipal()).thenReturn(user);
        when(jwtService.generateAccessToken(any(User.class))).thenReturn("accessToken");
        when(jwtService.generateRefreshToken(any(User.class))).thenReturn("refreshToken");
//
        //act
        String [] tokens = authService.login(user.getEmail(), user.getPassword());

        //assert
        assertThat(tokens).hasSize(2);
        assertThat(tokens[0]).isEqualTo("accessToken");
        assertThat(tokens[1]).isEqualTo("refreshToken");

    }

    @Test
    void testSignUp_WhenSuccess(){
        //arrange
        when(userRepository.findByEmail(anyString())).thenReturn(Optional.empty());
        when(userRepository.save(any(User.class))).thenReturn(user);


        //act
        SignUpDto signUpDto = new SignUpDto();
        signUpDto.setEmail("test@gmail.com");
        signUpDto.setPassword("testPassword");
        UserDto userDto = authService.signUp(signUpDto);

        //assert
        assertThat(userDto).isNotNull();
        assertThat(userDto.getEmail()).isEqualTo(signUpDto.getEmail());
//        verify(riderService.createNewRider(any(User.class)));
//        verify(walletService.createNewWallet(any(User.class)));

    }



}
