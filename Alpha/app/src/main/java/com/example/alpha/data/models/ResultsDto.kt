package com.example.alpha.data.models

import com.example.alpha.entity.ResultsInterface

data class ResultsDto(override val results: List<SingleResultDto>):ResultsInterface
