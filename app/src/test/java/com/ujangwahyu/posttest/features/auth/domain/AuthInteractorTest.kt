package com.ujangwahyu.posttest.features.auth.domain

import com.ujangwahyu.posttest.common.DataEnum
import com.ujangwahyu.posttest.features.auth.domain.model.User
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

/**
 * Created by wahyouwebid on 19 September 2023
 * Email: wahyouwebid@gmail.com
 * Github: github.com/wahyouwebid
 * Linkedin: linkedin.com/in/wahyouwebid,
 */

class AuthInteractorTest {

    @Mock
    private lateinit var repository: AuthRepository

    private lateinit var interactor: AuthInteractor

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        interactor = AuthInteractor(repository)
    }

    /** Test store data **/
    @Test
    fun testSignUp() {
        val user = User(
            "wahyouwebid",
            "wahyouwebid",
            "1234567890123456",
            "wahyouwebid@gmail.com",
            "wahyouwebid"
        )

        interactor.signUp(user)

        Mockito.verify(repository).signUp(user)
    }

    /** Test dengan user password yang benar **/
    @Test
    fun testSignInValidCredentials() {
        val user = User(
            "wahyouwebid",
            "wahyouwebid",
            "1234567890123456",
            "wahyouwebid@gmail.com",
            "wahyouwebid"
        )

        `when`(repository.signIn()).thenReturn(user)

        val result = interactor.signIn("wahyouwebid", "wahyouwebid")

        assertTrue(result.successful)
        assertEquals(DataEnum.SUCCESS.message, result.message)
        assertEquals(user, result.data)
    }

    /** Test dengan user password yang salah **/
    @Test
    fun testSignInInvalidCredentials() {
        val user = User(
            "ujangwahyu",
            "wahyouwebid",
            "1234567890123456",
            "wahyouwebid@gmail.com",
            "ujangwahyu"
        )

        `when`(repository.signIn()).thenReturn(user)

        val result = interactor.signIn("ujangwahyu", "ujangwahyu")

        assertFalse(result.successful)
        assertEquals(DataEnum.USER_INVALID.message, result.message)
    }

    @Test
    fun testValidateUsernameEmpty() {
        val emptyUsername = ""

        val result = interactor.validateUsername(emptyUsername)

        assertFalse(result.successful)
        assertEquals(DataEnum.USERNAME_EMPTY.message, result.message)
    }

    @Test
    fun testValidateUsernameInvalidLength() {
        val shortUsername = "uj"

        val result = interactor.validateUsername(shortUsername)

        assertFalse(result.successful)
        assertEquals(DataEnum.USERNAME_INVALID_LENGTH.message, result.message)
    }

    @Test
    fun testValidateUsernameValid() {
        val validUsername = "ujangwahyu"

        val result = interactor.validateUsername(validUsername)

        assertTrue(result.successful)
    }

    @Test
    fun testValidateUPasswordEmpty() {
        val emptyPassword = ""

        val result = interactor.validatePassword(emptyPassword)

        assertFalse(result.successful)
        assertEquals(DataEnum.PASSWORD_EMPTY.message, result.message)
    }

    @Test
    fun testValidatePasswordInvalidLength() {
        val shortPassword = "wah"

        val result = interactor.validatePassword(shortPassword)

        assertFalse(result.successful)
        assertEquals(DataEnum.PASSWORD_INVALID_LENGTH.message, result.message)
    }

    @Test
    fun testValidatePasswordValid() {
        val validUsername = "ujangwahyu"

        val result = interactor.validatePassword(validUsername)

        assertTrue(result.successful)
    }

    @Test
    fun testValidateUNameEmpty() {
        val emptyName = ""

        val result = interactor.validateName(emptyName)

        assertFalse(result.successful)
        assertEquals(DataEnum.NAME_EMPTY.message, result.message)
    }

    @Test
    fun testValidateNameInvalidLength() {
        val shortName = "wa"

        val result = interactor.validateName(shortName)

        assertFalse(result.successful)
        assertEquals(DataEnum.NAME_INVALID_LENGTH.message, result.message)
    }

    @Test
    fun testValidateNameValid() {
        val validUsername = "ujangwahyu"

        val result = interactor.validateName(validUsername)

        assertTrue(result.successful)
    }

    @Test
    fun testValidateNikEmpty() {
        val emptyNik = ""

        val result = interactor.validateNIK(emptyNik)

        assertFalse(result.successful)
        assertEquals(DataEnum.NIK_EMPTY.message, result.message)
    }

    @Test
    fun testValidateNikInvalidLength() {
        val shortNik = "12345678"

        val result = interactor.validateNIK(shortNik)

        assertFalse(result.successful)
        assertEquals(DataEnum.NIK_INVALID_LENGTH.message, result.message)
    }

    @Test
    fun testValidateNikValid() {
        val validUsername = "1234567890123456"

        val result = interactor.validateNIK(validUsername)

        assertTrue(result.successful)
    }

    @Test
    fun testValidateEmailEmpty() {
        val emptyEmail = ""

        val result = interactor.validateEmail(emptyEmail)

        assertFalse(result.successful)
        assertEquals(DataEnum.EMAIL_EMPTY.message, result.message)
    }

    @Test
    fun testValidateEmailInvalidFormat() {
        val shortEmail = "ujangwahyu@gmail"

        val result = interactor.validateEmail(shortEmail)

        assertFalse(result.successful)
        assertEquals(DataEnum.EMAIL_INVALID_FORMAT.message, result.message)
    }

    @Test
    fun testValidateEmailValid() {
        val validEmail = "ujangwahyu@gmail.com"

        val result = interactor.validateEmail(validEmail)

        assertTrue(result.successful)
    }
}