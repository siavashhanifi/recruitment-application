import { Competence } from './competence.entety';

/**
 * Model of competence profile of applicant. Representing years of work experience and listings of work experience.
 */
export class CompetenceProfile {
  competence: Competence[];
  yearsOfExperience: number;
}
