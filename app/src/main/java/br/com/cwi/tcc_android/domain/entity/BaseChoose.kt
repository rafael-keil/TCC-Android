package br.com.cwi.tcc_android.domain.entity


class BaseChoose(
    val choose: Int,
    val type: String,
    val from: List<ChooseOption>,
)
