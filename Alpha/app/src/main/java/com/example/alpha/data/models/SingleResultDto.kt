package com.example.alpha.data.models

import com.example.alpha.entity.SingleResultInterface

data class SingleResultDto(
    override val subsection: String,
    override val multimedia: List<SingleMultimediaDto>
):SingleResultInterface
