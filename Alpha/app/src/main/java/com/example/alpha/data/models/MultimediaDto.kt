package com.example.alpha.data.models

import com.example.alpha.entity.MultimediaInterface
import com.example.alpha.entity.SingleMultimediaInterface

data class MultimediaDto(override val multimedia: List<SingleMultimediaInterface>):MultimediaInterface
