package com.pirris.network

import java.lang.Exception

/**
 * Esto es una interfaz, la cuál establece 2 métodos onSuccess y on Failed
 * Uno recibe un resultado el cual puede variar y no es determinado, con T asignamos valores indeterminados
 * Y el otro recibe una excepción
 */
interface Callback<T>{

    fun onSuccess(result: T)

    fun onFailed(exception: Exception)
}