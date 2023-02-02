package com.tuotav.commerce.shorttoolbox.di.provider

import com.tuotav.feature.shorthelper.DouyinShortHackerService
import com.tuotav.feature.shorthelper.ShortHackerService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * ===============================================
 * <p> </p>
 * -----------------------------------------------
 * @author Jia Junjian
 * @since 2023/2/2 11:22
 */
@Module
@InstallIn(SingletonComponent::class)
class ShortParsingServiceModule {

    @Provides
    @Singleton
    fun provideDouyingParsingShortService(): ShortHackerService {
        return DouyinShortHackerService()
    }
}