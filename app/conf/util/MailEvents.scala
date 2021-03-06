package conf.util

import javax.inject.Singleton

@Singleton
object MailEvents {
  def MAIL: String = "MAIL"

  def MAIL_SENT: String = "MAIL SENT"

  def MAIL_SENT_FAILED: String = "MAIL SENT FAILED"

  def PASSWORD_RESET: String = "PASSWORD RESET"

  def NO_PERSON_FOUND: String = "NO PERSON FOUND"

}
