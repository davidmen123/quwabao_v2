package com.gedoumi.quwabao.guess.service;

import com.gedoumi.quwabao.common.component.RedisCache;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Redis Key过期通知类
 *
 * @author Minced
 */
@Slf4j
@Service
public class GuessExpiredMessageDelegate implements MessageListener {

    @Resource
    private GuessService guessService;

    @Resource
    private GuessDetailService guessDetailService;

    @Resource
    private GuessBetService guessBetService;

    @Resource
    private RedisCache redisCache;

    /**
     * Redis过期通知（回调）
     *
     * @param message 返回信息（此参数为过期的key值）
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void onMessage(@NonNull Message message, byte[] pattern) {
//        // 如果不是竞猜详情，直接返回
//        String messageStr = new String(message.getBody());
//        String[] messageSplit = messageStr.split("-");
//        if (!StringUtils.equals(messageSplit[0], "guessDetail")) {
//            return;
//        }
//        // 获取ID查询竞猜详情
//        Long guessDetailId = Long.parseLong(messageSplit[1]);
//        GuessDetail guessDetail = guessDetailService.getById(guessDetailId);
//        // 查询竞猜期
//        Guess guess = guessService.getById(guessDetail.getGuessId());
//        // 判断竞猜详情状态
//        Integer guessDetailStatus = guessDetail.getGuessDetailStatus();
//        if (guessDetailStatus.equals(GuessDetailStatusEnum.BETTING.getValue())) {
//            // 从下注期到开奖期
//            log.debug("下注期 -- 游戏期");
//            // 获取排名
//            String ranking = guessDetailService.getRanking(guessDetail, guess.getGuessReturn());
//            RankingVO rankingVO = new RankingVO();
//            rankingVO.setIssue(String.valueOf(guessDetail.getIssueNumber()));
//            rankingVO.setCar1(String.valueOf(ranking.charAt(0)));
//            rankingVO.setCar2(String.valueOf(ranking.charAt(1)));
//            rankingVO.setCar3(String.valueOf(ranking.charAt(2)));
//            rankingVO.setCar4(String.valueOf(ranking.charAt(3)));
//            rankingVO.setCar5(String.valueOf(ranking.charAt(4)));
//            rankingVO.setCar6(String.valueOf(ranking.charAt(5)));
//            // 给前端发送游戏开始的通知
//            guessService.sendMessage(GuessNotityTypeEnum.GAME_START, rankingVO);
//            // 重新设置Redis，不需要设置value
//            redisCache.setExpireKeyValueData(messageStr, null, (long) guess.getGameTime(), TimeUnit.SECONDS);
//
//        } else if (guessDetailStatus.equals(GuessDetailStatusEnum.GAMING.getValue())) {
//            // 从游戏到结果展示期
//            log.debug("游戏期 -- 结果展示期");
//            guessDetail.setGuessDetailStatus(GuessDetailStatusEnum.SHOW_RESULT.getValue());
//            guessDetailService.save(guessDetail);
//            // 重新设置Redis，不需要设置value
//            redisCache.setExpireKeyValueData(messageStr, null, (long) guess.getBounsTime(), TimeUnit.SECONDS);
//            // 修改所有中奖的下注状态和发奖金
//            guessBetService.guessRight(guessDetail);
//
//        } else if (guessDetailStatus.equals(GuessDetailStatusEnum.SHOW_RESULT.getValue())) {
//            // 从结果展示期到下一个周期
//            log.debug("结果展示期 -- 下一个周期");
//            guessDetail.setGuessDetailStatus(GuessDetailStatusEnum.FINISHED.getValue());
//            guessDetailService.save(guessDetail);
//            // 判断当前时间是否大于竞猜期结束的时间，如果大于则直接停止创建后续的竞猜详情
//            Date now = new Date();
//            if (now.getTime() >= guess.getEndTime().getTime()) {
//                // 把竞猜期状态置为结束
//                log.debug("已超出竞猜期结束时间，不在创建下一周期");
//                guess.setGuessStatus(GuessStatusEnum.FINISHED.getValue());
//                guessService.save(guess);
//                // 给前端发送投注期结束的通知
//                guessService.sendMessage(GuessNotityTypeEnum.GUESS_END, null);
//                // 自动创建下一场竞猜期
//                Calendar calendar = Calendar.getInstance();
//                calendar.setTime(now);
//                Date startTime;
//                Date endTime;
//                // 判断当前时间
//                // 如果是18点以前，创建当天18:00-21:00时间段的竞猜期
//                // 如果是18点以后，创建第二天11:00-14:00时间段的竞猜期
//                if (calendar.get(Calendar.HOUR_OF_DAY) < 18) {
//                    calendar.set(Calendar.HOUR_OF_DAY, 18);
//                    calendar.set(Calendar.MINUTE, 0);
//                    calendar.set(Calendar.SECOND, 0);
//                    startTime = calendar.getTime();
//
//                    calendar.set(Calendar.HOUR_OF_DAY, 21);
//                    calendar.set(Calendar.MINUTE, 0);
//                    calendar.set(Calendar.SECOND, 0);
//                    endTime = calendar.getTime();
//                } else {
//                    calendar.add(Calendar.DAY_OF_MONTH, 1);
//                    calendar.set(Calendar.HOUR_OF_DAY, 11);
//                    calendar.set(Calendar.MINUTE, 0);
//                    calendar.set(Calendar.SECOND, 0);
//                    startTime = calendar.getTime();
//
//                    calendar.set(Calendar.HOUR_OF_DAY, 13);
//                    calendar.set(Calendar.MINUTE, 0);
//                    calendar.set(Calendar.SECOND, 0);
//                    endTime = calendar.getTime();
//                }
//                // 判断开始时间与结束时间是否已经有重复的竞猜期，如果有，则不创建
//                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//                if (guessService.countByTime(sdf.format(startTime)) > 0 || guessService.countByTime(sdf.format(endTime)) > 0) {
//                    log.info("已经有重复的竞猜期");
//                    return;
//                }
//                // 创建
//                Guess saveGuess = new Guess();
//                saveGuess.setStartTime(startTime);
//                saveGuess.setEndTime(endTime);
//                guessService.save(saveGuess);
//                return;
//            }
//            log.debug("创建下一个竞猜详情");
//            // 创建新的竞猜详情、各玩法的赔率与各玩法的投注金额，获取返回的竞猜详情ID
//            Long newGuessDetailId = guessDetailService.createGuessDetailAndOddsAndMoney(guess, new Date());
//            // 设置Redis，过期时间从Guess对象中获取
//            redisCache.setExpireKeyValueData("guessDetail-" + newGuessDetailId, null, (long) guess.getBetTime(), TimeUnit.SECONDS);
//            // 给前端发送下注开始的通知
//            guessService.sendMessage(GuessNotityTypeEnum.BET_START, null);
//
//        } else {
//            log.error("其他情况");
//        }
    }

}
