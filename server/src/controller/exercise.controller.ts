import {Body, Controller, Delete, Get, Param, Post, Put, Req} from '@nestjs/common';
import {Exercise} from '../entity/exercise.entity';
import {ExerciseService} from '../service/exercise.service';
import {RoleVerificator} from '../authentication/role.verificator';
import {ImageService} from '../service/image.service';

@Controller('exercise')
export class ExerciseController {
    private readonly roleVerificator: RoleVerificator;

    constructor(private readonly exerciseService: ExerciseService,
                private readonly imageService: ImageService) {
        this.roleVerificator = new RoleVerificator('admin');
    }
    @Get()
    async findAll(@Req() request): Promise<Exercise[]> {
        this.roleVerificator.verify(request.user);
        return await this.exerciseService.findAll();
    }

    @Get(':id')
    async findOne(@Param('id') id: string){
        return await this.exerciseService.findOne(+id);
    }

    @Post()
    async create(@Req() request, @Body() exercise: Exercise) {
        this.roleVerificator.verify(request.user);
        if (exercise.images) {
            this.saveImages(exercise);
        }

        const createdExercise = await this.exerciseService.create(exercise);

        return { exercise: createdExercise };
    }

    private saveImages(exercise: Exercise) {
        //const { images } = exercise;

        //this.imageService.saveImages(images);
    }

    @Put(':id')
    async update(@Req() request, @Param('id') id: string, @Body() exercise: Partial<Exercise>) {
        this.roleVerificator.verify(request.user);
        return await this.exerciseService.update(+id, exercise);
    }

    @Delete(':id')
    async destroy(@Req() request, @Param('id') id: string) {
        this.roleVerificator.verify(request.user);
        await this.exerciseService.destroy(+id);
        return;
    }

}