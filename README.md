<div align="center">

<h1>RMineCounter</h1>

<p>在游戏中添加统计信息来统计玩家挖掘数据, 可以借助计分板显示出数据</p>

<br>

<img alt="GitHub" src="https://img.shields.io/github/license/DangoTown/RMC?logo=apache">
<img alt="GitHub Workflow Status" src="https://img.shields.io/github/actions/workflow/status/RTAkland/RMC/main.yml">
</div>

# 使用

* 默认是不会记录玩家挖掘数据的, 你需要添加一个计分板， 准则为`minecraft.custom:minecraft.rmc.dig`的一个计分板, 以下为实例命令, 如有需要可以自行修改

* `/scoreboard objectives add rmc minecraft.custom:minecraft.rmc.dig {"text":"挖掘榜", "color":"yellow"}`

* 上面的命令执行完成后所有玩家破坏任何方块都会使其加1(常规情况下破坏方块), 使用以下命令来显示出计分板

* `/scoreboard objectives setdisplay sidebar rmc`

* 你可以修改计分板的id和显示名称, 但是计分板的准则不能修改

# 开源

- 本项目以[Apache-2.0](./LICENSE)许可开源, 即:
    - 你可以直接使用该项目提供的功能, 无需任何授权
    - 你可以在**注明来源版权信息**的情况下对源代码进行任意分发和修改以及衍生

